package com.tensquare.friend.dao;

import com.tensquare.friend.pojo.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * User: sh0rk
 * Email:sh0rk@qq.com
 * Date: 2019/2/27 10:17
 * Description:
 **/
public interface FriendDao extends JpaRepository<Friend,String> {
    public Friend findByUseridAndFriendid(String userid,String friendid);

    @Modifying
    @Query(value = "UPDATE tb_friend SET islike=? WHERE userid = ? AND friendid = ?", nativeQuery = true)
    public void updateIslike(String islike, String userid, String friendid);

    @Modifying
    @Query(value = "delete FROM tb_friend WHERE userid = ? AND friendid = ?", nativeQuery = true)
    void deletefriend(String userid, String friendid);
}
