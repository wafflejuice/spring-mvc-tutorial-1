package hello.survlet.domain.member

object MemberRepository {
    /**
     * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
     */
    private val store = mutableMapOf<Long, Member>()
    private var sequence: Long = 0L

    fun save(member: Member): Member {
        member.id = ++sequence
        store[member.id] = member
        return member
    }

    fun findById(id: Long): Member? {
        return store[id]
    }

    fun findAll(): List<Member> {
        return store.values.toList()
    }

    fun clearStore() {
        store.clear()
    }
}