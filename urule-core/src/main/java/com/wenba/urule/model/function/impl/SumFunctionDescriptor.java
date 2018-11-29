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
package com.wenba.urule.model.function.impl;

import java.math.BigDecimal;
import java.util.Collection;

import com.wenba.urule.RuleException;
import com.wenba.urule.Utils;
import com.wenba.urule.model.function.Argument;
import com.wenba.urule.model.function.FunctionDescriptor;
import com.wenba.urule.runtime.WorkingMemory;


/**
 * @author Jacky.gao
 * @since 2015年7月22日
 */
public class SumFunctionDescriptor implements FunctionDescriptor {
	private boolean disabled=false;
	
	public boolean isDisabled() {
		return disabled;
	}
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	@Override
	public String getLabel() {
		return "求和";
	}
	@Override
	public String getName() {
		return "Sum";
	}
	@Override
	public Object doFunction(Object object, String property,WorkingMemory workingMemory) {
		Collection<?> list=null;
		if(object instanceof Collection){
			list=(Collection<?>)object;
		}else{
			throw new RuleException("Function[sum] parameter must be java.util.Collection type.");
		}
		BigDecimal total=null;
		for(Object obj:list){
			Object pvalue=Utils.getObjectProperty(obj, property);
			BigDecimal a=Utils.toBigDecimal(pvalue);
			if(total==null){
				total=a;
			}else{
				total=total.add(a);
			}
		}
		return total.doubleValue();
	}
	@Override
	public Argument getArgument() {
		Argument p=new Argument();
		p.setName("集合对象");
		p.setNeedProperty(true);
		return p;
	}
}
