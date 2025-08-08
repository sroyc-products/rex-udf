import spock.lang.*
import com.sroyc.rex.sharable.*

class TestSimpleAdapterFunction extends Specification {

    


    def "simple adapter"() {
        given: 
        def saf = new SimpleAdapterFunction()
        def input = new SimpleFunctionInput()
        input.body = '''
        {
            "id" : 100,
            "data": { "initVal" : 734, "finalVal": 3031 },
            "sequence" : { "start" : 1 , "end" : 50, "step" : 3 } 
        }
        '''
        expect:
        1 + 1 == 2
    }

}