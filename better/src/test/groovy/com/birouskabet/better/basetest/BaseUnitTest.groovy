package com.birouskabet.better.basetest

import spock.lang.Specification

import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates

class BaseUnitTest extends Specification {

    def setupSpec() {
        loadTemplates("br.com.bradesco.opbk.pj.consent.payment.fixtures")
    }
}

