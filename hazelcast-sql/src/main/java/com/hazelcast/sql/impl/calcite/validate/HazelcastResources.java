/*
 * Copyright (c) 2008-2021, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.sql.impl.calcite.validate;

import org.apache.calcite.runtime.CalciteException;
import org.apache.calcite.runtime.Resources;
import org.apache.calcite.sql.validate.SqlValidatorException;

/**
 * Error messages for parsing and validation stages.
 */
public interface HazelcastResources {

    HazelcastResources RESOURCES = Resources.create(HazelcastResources.class);

    @Resources.BaseMessage("Function ''{0}'' does not exist")
    Resources.ExInst<CalciteException> functionDoesNotExist(String functionName);

    @Resources.BaseMessage("Cannot apply {0} operator to {1} (consider adding an explicit CAST)")
    Resources.ExInst<SqlValidatorException> invalidOperatorOperands(String operatorName, String operandTypes);

    @Resources.BaseMessage("Cannot apply {0} function to {1} (consider adding an explicit CAST)")
    Resources.ExInst<SqlValidatorException> invalidFunctionOperands(String functionName, String operandTypes);

    @Resources.BaseMessage("CAST function cannot convert value of type {0} to type {1}")
    Resources.ExInst<SqlValidatorException> cannotCastValue(String sourceType, String targetType);

    @Resources.BaseMessage("CAST function cannot convert literal {0} to type {1}: {2}")
    Resources.ExInst<SqlValidatorException> cannotCastLiteralValue(String sourceValue, String targetType, String message);

    @Resources.BaseMessage("Cannot infer return type for {1} among {0}")
    Resources.ExInst<SqlValidatorException> cannotInferCaseResult(String types, String operator);
}
