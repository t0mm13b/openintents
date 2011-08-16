/* 
 * Copyright (C) 2011 OpenIntents.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openintents.historify.data.model;

/**
 * 
 * Model class representing a Contact in the device's contact list.
 * 
 * @author berke.andras
 */
public class Contact {
	
	//CONTACT_LOOKUP_KEY
	private String mKey;
	
	//displayed name
	private String mName;
	private long mLastTimeContacted;
	
	private String mGivenName;

	
	public Contact(String key, String name, long lastTimeContacted) {
		this.mKey = key;
		this.mName = name;
		this.mLastTimeContacted = lastTimeContacted;
	}

	public String getName() {
		return mName;
	}

	public String getGivenName() {
		return mGivenName;
	}
	
	public void setGivenName(String givenName) {
		this.mGivenName = givenName;
	}
	
	public String getLookupKey() {
		return mKey;
	}

	public long getLastTimeContacted() {
		return mLastTimeContacted;
	}
	

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((mKey == null) ? 0 : mKey.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Contact other = (Contact) obj;
//		if (mKey == null) {
//			if (other.mKey != null)
//				return false;
//		} else if (!mKey.equals(other.mKey))
//			return false;
//		return true;
//	}
	
}
