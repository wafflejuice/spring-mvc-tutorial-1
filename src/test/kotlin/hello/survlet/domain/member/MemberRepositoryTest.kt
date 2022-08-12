package hello.survlet.domain.member

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

internal class MemberRepositoryTest {

    private val memberRepository = MemberRepository

    @AfterEach
    fun afterEach() {
        memberRepository.clearStore()
    }

    @Test
    fun save() {
        //given
        val member = Member(username = "kim", age = 20)

        //when
        val savedMember = memberRepository.save(member)

        //then
        val foundMember = memberRepository.findById(savedMember.id)
        assertThat(foundMember).isEqualTo(savedMember)
    }

    @Test
    fun findAll() {
        //given
        val member1 = Member(username = "member1", age = 20)
        val member2 = Member(username = "member2", age = 30)

        //when
        memberRepository.save(member1)
        memberRepository.save(member2)

        //then
        val result = memberRepository.findAll()
        assertThat(result.size).isEqualTo(2)
        assertThat(result).contains(member1, member2)
    }
}