package obj.mapper;

import obj.Member;

import org.apache.ibatis.annotations.Select;

public interface MemberMapper {
  @Select("SELECT * FROM tbl_member WHERE id = #{id}")
  Member selectMember(String id);
}