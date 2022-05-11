package com.cqrs.axon_poc.query.queryResolver;

import com.cqrs.axon_poc.command.entity.Address;
import com.cqrs.axon_poc.command.entity.Profile;
import com.cqrs.axon_poc.query.queries.GetAddressQuery;
import com.cqrs.axon_poc.query.queries.GetProfileQuery;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProfileQueryResolver implements GraphQLQueryResolver {

    private QueryGateway queryGateway;

    public ProfileQueryResolver(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    public List<Profile> getAllProfiles() {
        GetProfileQuery getProfileQuery = new GetProfileQuery();
        List<Profile> profiles = queryGateway.query(getProfileQuery, ResponseTypes.multipleInstancesOf(Profile.class)).join();
        return profiles;
    }

    public List<Address> getAllAddress() {
        GetAddressQuery getAddressQuery = new GetAddressQuery();
        List<Address> addresses = queryGateway.query(getAddressQuery, ResponseTypes.multipleInstancesOf(Address.class)).join();
        return addresses;
    }

}
