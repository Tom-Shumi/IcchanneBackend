package jp.ne.icchannel.backend.resolver

import graphql.kickstart.tools.GraphQLQueryResolver
import jp.ne.icchannel.backend.domain.Thread
import jp.ne.icchannel.backend.service.ThreadService
import org.springframework.stereotype.Component

@Component
class ThreadQueryResolver(private val threadService: ThreadService): GraphQLQueryResolver {

    fun getNewThreadList(search: String?, next: String?): List<Thread> {
        return threadService.getNewThreadList(search, next)
    }
}