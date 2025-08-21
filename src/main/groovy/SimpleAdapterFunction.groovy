/* groovylint-disable ClassJavadoc */
import com.sroyc.rex.sharable.*

import java.util.Map.Entry
import groovy.json.*

class SimpleAdapterFunction extends UserDefinedFunction.SingleIOFunction {
    

    def jsp = new JsonSlurper()

    ExecParameters apply(ExecParameters param) {
        String body = param.body
        // int statusCode = param.statusCode
        Map<String, List<String>> headers =  param.headers
        Map<String, String> queryMap =  param.queryParams
        Map<String, String> pathParams =  param.pathParams
        
        def obj = jsp.parseText(body) // This is essentially a map
        def out = new OutputBody()
        /// here goes transformation logic
        out.id = obj.id
        out.primes = [];
        for(int i=obj.data.initVal; i<obj.data.finalVal;i++) {
              def val = 2, factors = 0;
               while(val < i && factors==0) {
                if(i%val==0) {
                    factors++;
                }
                val++
               }
            if(factors==0) {
                out.primes.add(i);
            }
        }
        obj.hasNext = true;

        ExecParameters.ExecParametersBuilder rep = ExecParameters.builder().body(JsonOutput.toJson(out))

        for (Entry<String, List<String>> entry : headers.entrySet()) {
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
