package jp.ne.icchannel.backend.service

import com.fasterxml.jackson.databind.ObjectMapper
import jp.ne.icchannel.backend.Constants.Companion.ES_INDEX_THREAD
import jp.ne.icchannel.backend.domain.Thread
import org.elasticsearch.action.search.SearchRequest
import org.elasticsearch.search.builder.SearchSourceBuilder
import org.elasticsearch.search.sort.FieldSortBuilder
import org.elasticsearch.search.sort.SortOrder
import org.springframework.stereotype.Service

@Service
class ThreadService(private var elasticsearchService: ElasticsearchService,
                    private val objectMapper: ObjectMapper) {

    fun getNewThreadList(search: String?, next: String?): List<Thread> {
        val searchSourceBuilder = SearchSourceBuilder()
        searchSourceBuilder.sort(FieldSortBuilder("publishedDate").order(SortOrder.DESC))
        val request = SearchRequest(ES_INDEX_THREAD).source(searchSourceBuilder)
        val response = elasticsearchService.search(request)
        val searchHit = response.hits.hits

        return searchHit.map{ hit -> objectMapper.convertValue(hit.sourceAsMap, Thread::class.java)}.toList()
    }
}