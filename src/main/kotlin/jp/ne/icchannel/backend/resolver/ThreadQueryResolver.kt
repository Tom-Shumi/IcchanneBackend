package jp.ne.icchannel.backend.resolver

import graphql.kickstart.tools.GraphQLQueryResolver
import jp.ne.icchannel.backend.domain.Thread
import org.springframework.stereotype.Component

@Component
class ThreadQueryResolver: GraphQLQueryResolver {

    fun getNewThreadList(search: String?, next: String?): List<Thread> {
        return listOf()
    }
}