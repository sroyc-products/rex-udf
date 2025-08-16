/* groovylint-disable ClassJavadoc */
import com.sroyc.rex.sharable.*

import java.util.Map.Entry
import groovy.json.*
/**
This function assumes there is multiple inputs. Each input has certain data cues 
to implement and return only one output based on the input data
*/
class ConditionalAggregateFunction extends UserDefinedFunction.AggregateFunction {
    

    def jsp = new JsonSlurper()

    Map<String,RestExecParameters> apply(Map<String,SimpleFunctionInput> params) {

        Map<String,RestExecParameters> output = new HashMap<>();

        for (Entry<String, String> entry : params.entrySet()) {
            // Each entry can be identified by the origin source or function
            String serviceOrFunctionId = entry.getKey()
        }

        return output

    }

    class OutputBody {
        int id
        List<Integer> primes
        boolean hasNext
    }

}
