import spock.lang.*
import com.sroyc.rex.sharable.*
import groovy.json.*

class TestSimpleAdapterFunction extends Specification {

    
    def "simple adapter"() {
        given: 
            def input = new ExecParameters()
            input.body = '''
            {
                "id" : 100,
                "data": { "initVal" : 734, "finalVal": 3031 },
                "sequence" : { "start" : 1 , "end" : 50, "step" : 3 } 
            }
            '''

        when: 
            def saf = new SimpleAdapterFunction()
            def output = saf.apply(input)

        then:
            println JsonOutput.toJson(output)
           output!=null
    }

}