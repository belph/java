/******************************************************************************
 ** Copyright (c) 2014-2015 Basis Technology Corporation.
 **
 ** Licensed under the Apache License, Version 2.0 (the "License");
 ** you may not use this file except in compliance with the License.
 ** You may obtain a copy of the License at
 **
 **     http://www.apache.org/licenses/LICENSE-2.0
 **
 ** Unless required by applicable law or agreed to in writing, software
 ** distributed under the License is distributed on an "AS IS" BASIS,
 ** WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 ** See the License for the specific language governing permissions and
 ** limitations under the License.
 ******************************************************************************/

package com.basistech.rosette.apimodel;

/**
 * Class that represents the data from an entity resolution request
 */
public final class LinkedEntityRequest extends Request {

    /**
     * constructor for {@code LinkedEntityRequest}
     * @param language language code
     * @param content raw data
     * @param contentUri uri pointing to the data
     * @param contentType byte array of data
     * @param unit input unit code
     */
    public LinkedEntityRequest(
            String language,
            String content,
            String contentUri,
            String contentType,
            InputUnit unit
    ) {
        super(language, content, contentUri, contentType, unit);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * if the param is a {@code LinguisticsRequest}, compare contents for equality
     * @param o the object
     * @return whether or not the param object is equal to this object
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LinkedEntityRequest)) {
            return false;
        }

        return super.equals(o);
    }
}
