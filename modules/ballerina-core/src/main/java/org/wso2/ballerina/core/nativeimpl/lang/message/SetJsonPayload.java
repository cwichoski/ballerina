/**
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 **/

package org.wso2.ballerina.core.nativeimpl.lang.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.ballerina.core.interpreter.Context;
import org.wso2.ballerina.core.model.types.JSONType;
import org.wso2.ballerina.core.model.types.MessageType;
import org.wso2.ballerina.core.model.values.BValue;
import org.wso2.ballerina.core.model.values.JSONValue;
import org.wso2.ballerina.core.model.values.MessageValue;
import org.wso2.ballerina.core.nativeimpl.AbstractNativeFunction;
import org.wso2.ballerina.core.nativeimpl.annotations.Argument;
import org.wso2.ballerina.core.nativeimpl.annotations.BallerinaFunction;

/**
 * Set the payload of the Message as a JSON
 */
@BallerinaFunction(
        packageName = "ballerina.lang.message",
        functionName = "set",
        args = {@Argument(name = "message", type = MessageType.class),
                @Argument(name = "payload", type = JSONType.class)},
        isPublic = true
)
//@Component(
//        name = "func.lang.echo_setJsonPayload",
//        immediate = true,
//        service = AbstractNativeFunction.class
//)
public class SetJsonPayload extends AbstractNativeFunction {

    private static final Logger log = LoggerFactory.getLogger(SetJsonPayload.class);

    @Override
    public BValue[] execute(Context ctx) {
        log.info("SetJsonPayload Native Function Invoked.");
        // Accessing First Parameter Value.
        MessageValue msg = (MessageValue) getArgument(ctx, 0).getBValue();
        JSONValue payload = (JSONValue) getArgument(ctx, 1).getBValue();

        // Setting the payload
        msg.setBuiltPayload(payload);
        msg.setAlreadyRead(true);
        return VOID_RETURN;
    }
}