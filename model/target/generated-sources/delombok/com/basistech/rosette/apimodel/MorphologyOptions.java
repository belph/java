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
import com.basistech.util.PartOfSpeechTagSet;

/**
 * Morphology options
 */
@JacksonMixin
public final class MorphologyOptions extends Options {
    /**
     */
    private final Boolean disambiguate;
    /**
     * DocumentRequest query processing. Linguistics analysis may change its behavior
     * to reflect the fact that query input is often not in full sentences;
     * Typically, this disables disambiguation.
     *
     * Linguistics analysis may change its behavior to reflect the fact that query input is often
     * not in full sentences; Typically, this disables disambiguation.
     */
    private final Boolean query;
    /**
     *
     * indicates the default.
     */
    private final PartOfSpeechTagSet partOfSpeechTagSet;

    @java.beans.ConstructorProperties({"disambiguate", "query", "partOfSpeechTagSet"})
    @SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    MorphologyOptions(final Boolean disambiguate, final Boolean query, final PartOfSpeechTagSet partOfSpeechTagSet) {
        this.disambiguate = disambiguate;
        this.query = query;
        this.partOfSpeechTagSet = partOfSpeechTagSet;
    }


    @SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public static class MorphologyOptionsBuilder {
        @SuppressWarnings("all")
        @javax.annotation.Generated("lombok")
        private Boolean disambiguate;
        @SuppressWarnings("all")
        @javax.annotation.Generated("lombok")
        private Boolean query;
        @SuppressWarnings("all")
        @javax.annotation.Generated("lombok")
        private PartOfSpeechTagSet partOfSpeechTagSet;

        @SuppressWarnings("all")
        @javax.annotation.Generated("lombok")
        MorphologyOptionsBuilder() {
        }

        @SuppressWarnings("all")
        @javax.annotation.Generated("lombok")
        public MorphologyOptionsBuilder disambiguate(final Boolean disambiguate) {
            this.disambiguate = disambiguate;
            return this;
        }

        @SuppressWarnings("all")
        @javax.annotation.Generated("lombok")
        public MorphologyOptionsBuilder query(final Boolean query) {
            this.query = query;
            return this;
        }

        @SuppressWarnings("all")
        @javax.annotation.Generated("lombok")
        public MorphologyOptionsBuilder partOfSpeechTagSet(final PartOfSpeechTagSet partOfSpeechTagSet) {
            this.partOfSpeechTagSet = partOfSpeechTagSet;
            return this;
        }

        @SuppressWarnings("all")
        @javax.annotation.Generated("lombok")
        public MorphologyOptions build() {
            return new MorphologyOptions(disambiguate, query, partOfSpeechTagSet);
        }

        @Override
        @SuppressWarnings("all")
        @javax.annotation.Generated("lombok")
        public String toString() {
            return "MorphologyOptions.MorphologyOptionsBuilder(disambiguate=" + this.disambiguate + ", query=" + this.query + ", partOfSpeechTagSet=" + this.partOfSpeechTagSet + ")";
        }
    }

    @SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public static MorphologyOptionsBuilder builder() {
        return new MorphologyOptionsBuilder();
    }

    /**
     * @return whether the linguistics analysis should disambiguate results
     */
    @SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public Boolean getDisambiguate() {
        return this.disambiguate;
    }

    /**
     * DocumentRequest query processing. Linguistics analysis may change its behavior
     * to reflect the fact that query input is often not in full sentences;
     * Typically, this disables disambiguation.
     * @return request query processing
     * Linguistics analysis may change its behavior to reflect the fact that query input is often
     * not in full sentences; Typically, this disables disambiguation.
     */
    @SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public Boolean getQuery() {
        return this.query;
    }

    /**
     * @return the tag set used when returning part of speech tags. A {@code null} value
     * indicates the default.
     */
    @SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public PartOfSpeechTagSet getPartOfSpeechTagSet() {
        return this.partOfSpeechTagSet;
    }

    @Override
    @SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof MorphologyOptions)) return false;
        final MorphologyOptions other = (MorphologyOptions) o;
        if (!other.canEqual((Object) this)) return false;
        if (!super.equals(o)) return false;
        final Object this$disambiguate = this.getDisambiguate();
        final Object other$disambiguate = other.getDisambiguate();
        if (this$disambiguate == null ? other$disambiguate != null : !this$disambiguate.equals(other$disambiguate)) return false;
        final Object this$query = this.getQuery();
        final Object other$query = other.getQuery();
        if (this$query == null ? other$query != null : !this$query.equals(other$query)) return false;
        final Object this$partOfSpeechTagSet = this.getPartOfSpeechTagSet();
        final Object other$partOfSpeechTagSet = other.getPartOfSpeechTagSet();
        if (this$partOfSpeechTagSet == null ? other$partOfSpeechTagSet != null : !this$partOfSpeechTagSet.equals(other$partOfSpeechTagSet)) return false;
        return true;
    }

    @SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    protected boolean canEqual(final Object other) {
        return other instanceof MorphologyOptions;
    }

    @Override
    @SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + super.hashCode();
        final Object $disambiguate = this.getDisambiguate();
        result = result * PRIME + ($disambiguate == null ? 43 : $disambiguate.hashCode());
        final Object $query = this.getQuery();
        result = result * PRIME + ($query == null ? 43 : $query.hashCode());
        final Object $partOfSpeechTagSet = this.getPartOfSpeechTagSet();
        result = result * PRIME + ($partOfSpeechTagSet == null ? 43 : $partOfSpeechTagSet.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public String toString() {
        return "MorphologyOptions(disambiguate=" + this.getDisambiguate() + ", query=" + this.getQuery() + ", partOfSpeechTagSet=" + this.getPartOfSpeechTagSet() + ")";
    }
}
