package com.guedim.springbank.user.query.api.handlers;

import com.guedim.springbank.user.query.api.dto.UserLookupResponse;
import com.guedim.springbank.user.query.api.queries.FindAllUserQuery;
import com.guedim.springbank.user.query.api.queries.FindUserByIdQuery;
import com.guedim.springbank.user.query.api.queries.SearchUsersQuery;

public interface UserQueryHandler {

    UserLookupResponse getUserById(FindUserByIdQuery query);

    UserLookupResponse searchUsers(SearchUsersQuery query);

    UserLookupResponse getAllUsers(FindAllUserQuery query);
}
