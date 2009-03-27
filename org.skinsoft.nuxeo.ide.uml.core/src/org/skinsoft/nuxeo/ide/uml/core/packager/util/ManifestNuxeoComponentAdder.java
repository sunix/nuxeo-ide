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
package org.skinsoft.nuxeo.ide.uml.core.packager.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import org.skinsoft.nuxeo.ide.uml.core.packager.exception.ManifestGenerationException;

public class ManifestNuxeoComponentAdder {
	
	protected HashSet<String> nuxeoComponents ;
	
	public ManifestNuxeoComponentAdder() {
		this.nuxeoComponents = new HashSet<String>() ;
	}
	
	public void addNuxeoComponent( String nxc ) {
		this.nuxeoComponents.add( nxc ) ;
	}
	
	
	public void generatePackageManifest( File manifestFile ) throws ManifestGenerationException {
		try {
			this.nuxeoComponents.addAll( this.getNuxeoComponentsFromFile( manifestFile ) ) ;
		} catch (IOException e) {
			throw new ManifestGenerationException( e ) ;
		}
		
		if( ! manifestFile.exists() ) {
			manifestFile.getParentFile().mkdirs() ;
			try {
				manifestFile.createNewFile() ;
			} catch (IOException e) {
				throw new ManifestGenerationException( "Error creating manifest file " + manifestFile.getAbsolutePath() , e ) ;
			}
		}
		
		StringBuffer manifestStart;
		try {
			manifestStart = this.getManifestUntilNuxeoComponents( manifestFile );
		} catch (IOException e) {
			throw new ManifestGenerationException( e ) ;
		}
		
		BufferedWriter writer = null ;
		try {
			writer = new BufferedWriter( new FileWriter( manifestFile ) ) ;
			
			// copy file
			writer.write( manifestStart.toString() ) ;
			
			writer.write( "Nuxeo-Component: \n" ) ;
			for( Iterator<String> components = this.nuxeoComponents.iterator() ; components.hasNext() ; ) {
				writer.write( " " + components.next().trim() ) ;
				if( components.hasNext() ) {
					writer.write( "," ) ;
				}
				writer.write( "\n" ) ;
			}
			
			writer.write( "\n" ) ;
			
		} catch (IOException e) {
			throw new ManifestGenerationException( "Error writing manifest file " + manifestFile.getAbsolutePath() , e ) ;
		} finally {
			if( writer != null ) {
				try {
					writer.flush() ;
					writer.close() ;
				} catch (IOException e) {
					throw new ManifestGenerationException( "Error closing manifest file " + manifestFile.getAbsolutePath() , e ) ;
				}
			}
		}
	}
	
	protected ArrayList<String> getNuxeoComponentsFromFile( File manifestFile ) throws IOException {
		
		ArrayList<String> result = new ArrayList<String>() ;
		
		BufferedReader reader = null ;
		try {
			reader = new BufferedReader( new FileReader( manifestFile ) ) ;
			
			StringBuffer sb = new StringBuffer() ;
			
			boolean keywordFound = false ;
			for( String line = reader.readLine() ; line != null ; line = reader.readLine() ) {
				if( line.startsWith( "Nuxeo-Component:" ) ) {
					keywordFound = true ;
					
					sb.append( line.substring( "Nuxeo-Component:".length() ) ) ;
				} else {
					if( keywordFound ) {
						sb.append( line ) ;
					}
				}
			}
			
			String [] splitted = sb.toString().split( "," ) ;
			
			for( String component : splitted ) {
				if( ! "".equals( component.trim() ) && ! component.trim().startsWith( "OSGI-INF/uml/" ) ) {
					result.add( component.trim() ) ;
				}
			}
			
			return result ;
		} finally {
			if( reader != null ) {
				reader.close() ;
			}
		}
	}
	
	protected StringBuffer getManifestUntilNuxeoComponents( File manifestFile ) throws IOException {
		StringBuffer result = new StringBuffer() ;
		
		BufferedReader reader = null ;
		try {
			reader = new BufferedReader( new FileReader( manifestFile ) ) ;
			
			for( String line = reader.readLine() ; line != null ; line = reader.readLine() ) {
				if( line.startsWith( "Nuxeo-Component:" ) ) {
					break ;
				} else {
					result.append( line ) ;
					result.append( "\n" ) ;
				}
			}
		} finally {
			if( reader != null ) {
				reader.close() ;
			}
		}
		
		return result ;
	}

	
}
