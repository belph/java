/*
* Copyright 2017 Basis Technology Corp.
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

package com.basistech.rosette.apimodel;

import com.basistech.rosette.annotations.JacksonMixin;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Collection;

/**
 *  Information returned from the sentiment endpoint.
 **/
@Getter
@EqualsAndHashCode
@Builder
@JacksonMixin
public  class SentimentResponse extends Response {

    /**
     * @return the whole-document sentiment.
     */
    private final Label document;

    /**
     * @return the information for individual entities.
     */
    private final Collection<Entity> entities;
}
