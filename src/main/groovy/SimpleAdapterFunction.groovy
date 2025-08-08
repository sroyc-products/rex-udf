/* groovylint-disable ClassJavadoc */
import com.sroyc.rex.sharable.*

import java.util.Map.Entry
import groovy.json.JsonSlurper

class SimpleAdapterFunction extends UserDefinedFunction.SingleIOFunction {
    

    def jsp = new JsonSlurper()

    RestExecParameters apply(SimpleFunctionInput param) {
        String body = param.body
        // int statusCode = param.statusCode
        Map<String, String> headers =  param.headers
        Map<String, String> queryMap =  param.queryMap
        Map<String, String> pathParams =  param.pathParams
        
        def obj = jsp.parse(body) // This is essentially a map
        def out = new OutputBody()
        /// here goes transformation logic

        

        
        print 'This is just a sample'

        RestExecParameters.RestExecParametersBuilder rep = RestExecParameters.builder().body(body)

        for (Entry<String, String> entry : headers.entrySet()) {
            rep.header(entry.getKey(), entry.getValue())
        }
        for (Entry<String, String> entry : queryMap.entrySet()) {
            rep.queryParam(entry.getKey(), entry.getValue())
        }
        for (Entry<String, String> entry : pathParams.entrySet()) {
            rep.pathParam(entry.getKey(), entry.getValue())
        }

        return rep.build()
    }

    class OutputBody {
        int id
        List<Integer> primes
        boolean hasNext
    }

}
