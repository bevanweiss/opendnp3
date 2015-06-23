/**
 * Licensed to Green Energy Corp (www.greenenergycorp.com) under one or
 * more contributor license agreements. See the NOTICE file distributed
 * with this work for additional information regarding copyright ownership.
 * Green Energy Corp licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * This project was forked on 01/01/2013 by Automatak, LLC and modifications
 * may have been made to this file. Automatak, LLC licenses these modifications
 * to you under the terms of the License.
 */

#include "UpdateKey.h"

namespace secauth
{

UpdateKey::UpdateKey() :
	updateKeyMode(opendnp3::UpdateKeyMode::AES128),			
	buffer(32),
	updateKeyView(buffer.ToReadOnly().Take(16))
{
	buffer.GetWriteBufferView().SetAllTo(0xFF);
}

opendnp3::UpdateKeyMode UpdateKey::GetKeyInfo(openpal::ReadBufferView& key) const
{
	key = updateKeyView;
	return updateKeyMode;
}
				
bool UpdateKey::SetUpdateKey(const openpal::ReadBufferView& key)
{
	switch (key.Size())
	{
	case(16) :
		this->updateKeyMode = opendnp3::UpdateKeyMode::AES128;
		this->updateKeyView = key.CopyTo(buffer.GetWriteBufferView());
		return true;
	case(32):
		this->updateKeyMode = opendnp3::UpdateKeyMode::AES256;
		this->updateKeyView = key.CopyTo(buffer.GetWriteBufferView());
		return true;
	default:
		return false;
	}
}

}



