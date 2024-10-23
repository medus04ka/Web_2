package org.example;
//
////import com.fastcgi.FCGIInterface;
//
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.HashMap;
//import java.util.Map;
//
public class Past {
//
//        static double r;
//        private static final String RESULT_JSON = """
//            {
//                "answer": %b,
//                "executionTime": "%s",
//                "serverTime": "%s"
//            }
//            """;
//        private static final String HTTP_RESPONSE = """
//            HTTP/1.1 200 OK
//            Content-Type: application/json
//            Content-Length: %d
//
//            %s
//            """;
//        private static final String HTTP_ERROR = """
//            HTTP/1.1 400 Bad Request
//            Content-Type: application/json
//            Content-Length: %d
//
//            %s
//            """;
//        private static final String ERROR_JSON = """
//            {
//                "error": "Хватит ломать мне лабу((",
//                "reason": "%s"
//            }
//            """;
//
//        public static void main(String[] args) throws IOException {
//       //     var fcgiInterface = new FCGIInterface();
//       //     while (fcgiInterface.FCGIaccept() >= 0) {
//
//                try {
//                    var queryParams = System.getProperties().getProperty("QUERY_STRING");
//

//
//                    var json = String.format(RESULT_JSON, insideRectangle1 || insideRectangle2 || insideRectangle3 ||
//                            insidePolygon1 || insidePolygon2 || insidePolygon3, );
//                    var responseBody = json.trim();
//                    var response = String.format(HTTP_RESPONSE, responseBody.getBytes(StandardCharsets.UTF_8).length, responseBody);
//                    try {
//                     //   FCGIInterface.request.outStream.write(response.getBytes(StandardCharsets.UTF_8));
//                        //FCGIInterface.request.outStream.flush();
//              //      } catch (IOException e) {
//                //        e.printStackTrace();
//            //        }
//
//                } catch (Exception ex) {
//               //     var json = String.format(ERROR_JSON, ex.getMessage());
//                  //  var responseBody = json.trim();
//                  //  var response = String.format(HTTP_ERROR, responseBody.getBytes(StandardCharsets.UTF_8).length, responseBody);
//                 //   FCGIInterface.request.outStream.write(response.getBytes(StandardCharsets.UTF_8));
//                //    FCGIInterface.request.outStream.flush();
//                }
//            // }
//     //   }
//

}
