/*
 * (C) Copyright 2009 SKIN-SOFT (http://www.skin-soft.org/) and contributors.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * Contributors:
 *     SKIN-SOFT - initial API and implementation
 *
 */
package org.skinsoft.nuxeo.ide.uml.core.uml;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.util.UMLSwitch;

public class CDAbstractSwitch extends UMLSwitch<EObject> {

	public static final String DOCUMENT_DATA_TYPE_NAME = "Document";
	public static final String DOCUMENTPART_DATA_TYPE_NAME = "DocumentPart";
	public static final String DIRECTORY_DATA_TYPE_NAME = "Directory";

	

	/* *************************************************************************
	 * Classification methods
	 */
	
	protected boolean isDocument(Class object) {
		for( Generalization generalization : object.getGeneralizations() ) {
			Classifier general = generalization.getGeneral() ;
			if( general instanceof Class && this.isDocument( (Class) general ) ) {
				return true ;
			} else if( DOCUMENT_DATA_TYPE_NAME.equals( general.getName() ) ) {
				return true ;
			}
		}
		return false ;
	}

	protected boolean isDocumentPart(Class object) {
		for( Generalization generalization : object.getGeneralizations() ) {
			Classifier general = generalization.getGeneral() ;
			if( general instanceof Class && this.isDocumentPart( (Class) general ) ) {
				return true ;
			} else if( DOCUMENTPART_DATA_TYPE_NAME.equals( general.getName() ) ) {
				return true ;
			}
		}
		return false ;
	}

	protected boolean isDirectory(DataType object) {
		for( Generalization generalization : object.getGeneralizations() ) {
			Classifier general = generalization.getGeneral() ;
			if( DIRECTORY_DATA_TYPE_NAME.equals( general.getName() ) ) {
				return true ;
			} else if( general instanceof DataType && this.isDirectory( (DataType) general ) ) {
				return true ;
			}
		}
		return false ;
	}

	protected boolean isDirectoryInstance(Class object) {
		for( Generalization generalization : object.getGeneralizations() ) {
			Classifier general = generalization.getGeneral() ; 
			if( object.isAbstract() && DIRECTORY_DATA_TYPE_NAME.equals( general.getName() ) ) {
				return true ;
			}
			if( general instanceof DataType && this.isDirectory( (DataType) general ) ) {
				return true ;
			}
		}
		return false ;
	}
	
	
	protected boolean hasGeneralization( Classifier object , String generalizationName ) {
		for( Generalization generalization : object.getGeneralizations() ) {
			Classifier general = generalization.getGeneral() ;
			if( generalizationName.equals( general.getName() ) ) {
				return true ;
			}
		}
		for( Generalization generalization : object.getGeneralizations() ) {
			if( this.hasGeneralization( generalization.getGeneral() , generalizationName ) ) {
				return true ;
			}
		}
		
		return false ;
	}
	
	protected boolean isFacet() {
		return false ;
	}
	
	/* *************************************************************************
	 * Utility methods
	 */

	protected <T extends EObject> List<T> filterList( EList list , java.lang.Class<T> c ) {
		ArrayList<T> result = new ArrayList<T>() ;
		
		for( Object elmt : list ) {
			if( c.isAssignableFrom( elmt.getClass() ) ) {
				result.add( (T) elmt ) ;
			}
		}
		
		return result ;
	}

	protected List<Class> getDocumentParts(Class object) {
		ArrayList<Class> result = new ArrayList<Class>() ;
		
		for( Association association : object.getAssociations() ) {
			if( object.equals( association.getEndTypes().get( 0 ) ) ) {
				
				Type targetType = association.getEndTypes().get( 1 ) ;
				Property targetProperty = (Property) association.getFeatures().get( 1 ) ;
				
				if( targetProperty.getAggregation() != null ) {
					if(
							targetProperty.getAggregation().equals( AggregationKind.COMPOSITE_LITERAL ) &&
							targetType instanceof Class &&
							this.isDocumentPart( (Class) targetType )
						) {
						result.add( (Class) targetType ) ;
					}
				}
				
			}
		}
		
		return result ;
	}
	
	protected List<Interface> getDocumentFacets( Class object ) {
		ArrayList<Interface> result = new ArrayList<Interface>() ;
		
		for( DirectedRelationship relationship : object.getTargetDirectedRelationships( UMLFactory.eINSTANCE.getUMLPackage().getRealization() ) ) {
			for( Element source : relationship.getSources() ) {
				if( source instanceof Interface ) {
					result.add( (Interface) source ) ;
				}
			}
		}
		
		return result ;
	}

	protected Classifier getSuperType(Class object) {
		for( Generalization generalization : object.getGeneralizations() ) {
			Classifier general = generalization.getGeneral() ;
			return general ;
		}
		return null ;
	}
	
	protected List<Constraint> lookupConstraints( Package pack , Element constrainedElement , String nameStartsWith ) {
		ArrayList<Constraint> result = new ArrayList<Constraint>() ;
		
		for( Constraint constraint : this.filterList( pack.getPackagedElements() , Constraint.class ) ) {
			boolean matches = true ;
			if( constrainedElement != null && ! constraint.getConstrainedElements().contains( constrainedElement ) ) {
				matches = false ;
			}
			if( nameStartsWith != null && ! constraint.getName().startsWith( nameStartsWith ) ) {
				matches = false ;
			}
			
			if( matches ) {
				result.add( constraint ) ;
			}
		}
		
		return result ;
	}
	
	
}
