package com.birouskabet.better.fixtures

import br.com.six2six.fixturefactory.Fixture
import br.com.six2six.fixturefactory.Rule
import br.com.six2six.fixturefactory.loader.TemplateLoader
import com.birouskabet.better.entity.Better

class BetterTemplate implements TemplateLoader{
    public final static String VALID_BETTER_INFO_REQUEST = "VALID_BETTER_INFO_REQUEST"
    public final static String BETTER_ALREADY_EXISTS = "BETTER_ALREADY_EXISTS"

    @Override
    void load() {
        Fixture.of(Better).addTemplate(VALID_BETTER_INFO_REQUEST, new Rule() {
            {
                add(personalId,"11111111111")
                add(cellphone, "011982418259")
                add(email, "birouska@gmail.com")
                add(name , "Alan do Nascimento Batista")
                add(password, "vclsidfaslfjadasfadkjadfadjaçdkjas")
            }
        })
    }


}
