package filter;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class CustomHeaderFilter implements Filter {

    private final String headerName;
    private final String headerValue;

    public CustomHeaderFilter(String headerName, String headerValue){
        this.headerName = headerName;
        this.headerValue = headerValue;
    }

    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {
        requestSpec.header(headerName, headerValue);
        return ctx.next(requestSpec, responseSpec);
    }
}
