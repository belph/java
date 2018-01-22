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

/**
 * Concepts found in a document.
 */
@JacksonMixin
public final class Concept {
    /**
     */
    private final String phrase;
    /**
     */
    private final Double salience;
    /**
     */
    private final String conceptId;

    @java.beans.ConstructorProperties({"phrase", "salience", "conceptId"})
    @SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    Concept(final String phrase, final Double salience, final String conceptId) {
        this.phrase = phrase;
        this.salience = salience;
        this.conceptId = conceptId;
    }


    @SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public static class ConceptBuilder {
        @SuppressWarnings("all")
        @javax.annotation.Generated("lombok")
        private String phrase;
        @SuppressWarnings("all")
        @javax.annotation.Generated("lombok")
        private Double salience;
        @SuppressWarnings("all")
        @javax.annotation.Generated("lombok")
        private String conceptId;

        @SuppressWarnings("all")
        @javax.annotation.Generated("lombok")
        ConceptBuilder() {
        }

        @SuppressWarnings("all")
        @javax.annotation.Generated("lombok")
        public ConceptBuilder phrase(final String phrase) {
            this.phrase = phrase;
            return this;
        }

        @SuppressWarnings("all")
        @javax.annotation.Generated("lombok")
        public ConceptBuilder salience(final Double salience) {
            this.salience = salience;
            return this;
        }

        @SuppressWarnings("all")
        @javax.annotation.Generated("lombok")
        public ConceptBuilder conceptId(final String conceptId) {
            this.conceptId = conceptId;
            return this;
        }

        @SuppressWarnings("all")
        @javax.annotation.Generated("lombok")
        public Concept build() {
            return new Concept(phrase, salience, conceptId);
        }

        @Override
        @SuppressWarnings("all")
        @javax.annotation.Generated("lombok")
        public String toString() {
            return "Concept.ConceptBuilder(phrase=" + this.phrase + ", salience=" + this.salience + ", conceptId=" + this.conceptId + ")";
        }
    }

    @SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public static ConceptBuilder builder() {
        return new ConceptBuilder();
    }

    /**
     * @return the concept text
     */
    @SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public String getPhrase() {
        return this.phrase;
    }

    /**
     * @return the concept salience
     */
    @SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public Double getSalience() {
        return this.salience;
    }

    /**
     * @return the concept id
     */
    @SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public String getConceptId() {
        return this.conceptId;
    }

    @Override
    @SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Concept)) return false;
        final Concept other = (Concept) o;
        final Object this$phrase = this.getPhrase();
        final Object other$phrase = other.getPhrase();
        if (this$phrase == null ? other$phrase != null : !this$phrase.equals(other$phrase)) return false;
        final Object this$salience = this.getSalience();
        final Object other$salience = other.getSalience();
        if (this$salience == null ? other$salience != null : !this$salience.equals(other$salience)) return false;
        final Object this$conceptId = this.getConceptId();
        final Object other$conceptId = other.getConceptId();
        if (this$conceptId == null ? other$conceptId != null : !this$conceptId.equals(other$conceptId)) return false;
        return true;
    }

    @Override
    @SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $phrase = this.getPhrase();
        result = result * PRIME + ($phrase == null ? 43 : $phrase.hashCode());
        final Object $salience = this.getSalience();
        result = result * PRIME + ($salience == null ? 43 : $salience.hashCode());
        final Object $conceptId = this.getConceptId();
        result = result * PRIME + ($conceptId == null ? 43 : $conceptId.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public String toString() {
        return "Concept(phrase=" + this.getPhrase() + ", salience=" + this.getSalience() + ", conceptId=" + this.getConceptId() + ")";
    }
}
