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
package org.skinsoft.nuxeo.ide.uml.core.util;

import java.util.ArrayList;

public class TransformationsUtils {
	
	static public char [] WORD_DELIMITER = { ' ' , '-' , '\'' } ; 
	
	static private boolean isWordDelimiter( char c ) {
		for( char d : WORD_DELIMITER ) {
			if( d == c ) return true ;
		}
		return false ;
	}
	
	static public String normaliseAttributeName( String id ) {
		
		StringBuffer result = new StringBuffer() ;
		boolean capitalizeNext = false ;
		
		for( int i = 0 ; i < id.length() ; i++ ) {
			if( isWordDelimiter( id.charAt( i ) ) ) {
				capitalizeNext = true ;
			} else if( capitalizeNext ) {
				result.append( Character.toUpperCase( id.charAt( i ) ) ) ;
				capitalizeNext = false ;
			} else {
				result.append( id.charAt( i ) ) ;
			}
		}
		
		return AsciiUtils.convertNonAscii( 
				result.toString().substring( 0 , 1 ).toLowerCase() + result.toString().substring( 1 ) 
			) ;
	}
	
	static public String normaliseTypeName( String id ) {
		String result = normaliseAttributeName( id ) ;
		if( result.length() > 0 ) {
			return AsciiUtils.convertNonAscii( result.substring( 0 , 1 ).toUpperCase() + result.substring( 1 ) ) ;
		} else {
			return AsciiUtils.convertNonAscii( result ) ;
		}
	}
	
	
}
