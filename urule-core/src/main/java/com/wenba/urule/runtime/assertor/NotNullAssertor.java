/*******************************************************************************
 * Copyright 2017 Bstek
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package com.wenba.urule.runtime.assertor;

import com.wenba.urule.model.library.Datatype;
import com.wenba.urule.model.rule.Op;
import org.apache.commons.lang.StringUtils;

/**
 * @author Jacky.gao
 * @since 2015年1月6日
 */
public class NotNullAssertor implements Assertor {

	public boolean eval(Object left, Object right, Datatype datatype) {
		if(left!=null && StringUtils.isNotBlank(left.toString())){
			return true;
		}else{
			return false;
		}
	}

	public boolean support(Op op) {
		return op.equals(Op.NotNull);
	}
}
