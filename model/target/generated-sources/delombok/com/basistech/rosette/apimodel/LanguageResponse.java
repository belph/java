// Generated by delombok at Mon Jan 22 15:21:35 EST 2018
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
import java.util.List;

/**
 * Simple api response data model for Rli
 */
@JacksonMixin
public class LanguageResponse extends Response {
    /**
     */
    private final List<LanguageDetectionResult> languageDetections;
    /**
     */
    private final List<LanguageRegionDetectionResult> regionalDetections;

    @java.beans.ConstructorProperties({"languageDetections", "regionalDetections"})
    @SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    LanguageResponse(final List<LanguageDetectionResult> languageDetections, final List<LanguageRegionDetectionResult> regionalDetections) {
        this.languageDetections = languageDetections;
        this.regionalDetections = regionalDetections;
    }


    @SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public static class LanguageResponseBuilder {
        @SuppressWarnings("all")
        @javax.annotation.Generated("lombok")
        private List<LanguageDetectionResult> languageDetections;
        @SuppressWarnings("all")
        @javax.annotation.Generated("lombok")
        private List<LanguageRegionDetectionResult> regionalDetections;

        @SuppressWarnings("all")
        @javax.annotation.Generated("lombok")
        LanguageResponseBuilder() {
        }

        @SuppressWarnings("all")
        @javax.annotation.Generated("lombok")
        public LanguageResponseBuilder languageDetections(final List<LanguageDetectionResult> languageDetections) {
            this.languageDetections = languageDetections;
            return this;
        }

        @SuppressWarnings("all")
        @javax.annotation.Generated("lombok")
        public LanguageResponseBuilder regionalDetections(final List<LanguageRegionDetectionResult> regionalDetections) {
            this.regionalDetections = regionalDetections;
            return this;
        }

        @SuppressWarnings("all")
        @javax.annotation.Generated("lombok")
        public LanguageResponse build() {
            return new LanguageResponse(languageDetections, regionalDetections);
        }

        @Override
        @SuppressWarnings("all")
        @javax.annotation.Generated("lombok")
        public String toString() {
            return "LanguageResponse.LanguageResponseBuilder(languageDetections=" + this.languageDetections + ", regionalDetections=" + this.regionalDetections + ")";
        }
    }

    @SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public static LanguageResponseBuilder builder() {
        return new LanguageResponseBuilder();
    }

    /**
     * @return the list of detected whole-document languages
     */
    @SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public List<LanguageDetectionResult> getLanguageDetections() {
        return this.languageDetections;
    }

    /**
     * @return the list of detected language regions
     */
    @SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public List<LanguageRegionDetectionResult> getRegionalDetections() {
        return this.regionalDetections;
    }

    @Override
    @SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof LanguageResponse)) return false;
        final LanguageResponse other = (LanguageResponse) o;
        if (!other.canEqual((Object) this)) return false;
        if (!super.equals(o)) return false;
        final Object this$languageDetections = this.getLanguageDetections();
        final Object other$languageDetections = other.getLanguageDetections();
        if (this$languageDetections == null ? other$languageDetections != null : !this$languageDetections.equals(other$languageDetections)) return false;
        final Object this$regionalDetections = this.getRegionalDetections();
        final Object other$regionalDetections = other.getRegionalDetections();
        if (this$regionalDetections == null ? other$regionalDetections != null : !this$regionalDetections.equals(other$regionalDetections)) return false;
        return true;
    }

    @SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    protected boolean canEqual(final Object other) {
        return other instanceof LanguageResponse;
    }

    @Override
    @SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + super.hashCode();
        final Object $languageDetections = this.getLanguageDetections();
        result = result * PRIME + ($languageDetections == null ? 43 : $languageDetections.hashCode());
        final Object $regionalDetections = this.getRegionalDetections();
        result = result * PRIME + ($regionalDetections == null ? 43 : $regionalDetections.hashCode());
        return result;
    }
}
