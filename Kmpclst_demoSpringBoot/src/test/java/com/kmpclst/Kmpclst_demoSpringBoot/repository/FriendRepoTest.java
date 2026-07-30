package com.kmpclst.Kmpclst_demoSpringBoot.repository;

import com.kmpclst.Kmpclst_demoSpringBoot.model.Friend;
import com.kmpclst.Kmpclst_demoSpringBoot.service.FriendService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static jdk.internal.classfile.impl.verifier.VerifierImpl.verify;
import static jdk.jfr.internal.jfc.model.Constraint.any;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FriendRepoTest {
    @Mock
    private FriendRepo friendRepo;
    @InjectMocks
    private FriendService friendService;

    private Friend friend;

    @BeforeEach
    void setUp() {
        friend = new Friend("Yoda", "Dagobah", 800);
    }

    @Test
    @DisplayName("Test findAll method of FriendRepo")
    public void testFindByName() {
        //friend = new Friend("Yoda", "Dagobah", 800);
        when(friendRepo.findByName("Yoda")).thenReturn(Optional.of(friend));

        var result = friendService.FindByName("Yoda");

        assertThat(result.isPresent());
        assertThat(result.get().getName()).isEqualTo("Yoda");
    }

    @Test

    public void testAddFriend() {
        friendService.AddFriend(friend);
        when(friendRepo.findByName("")).thenReturn(java.util.Optional.empty());
        when(friendRepo.save(any(Friend.class))).thenReturn(any(Friend.class));

        var result = friendService.AddFriend(new Friend("Anakin", "Naboo", 22));

        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo("Anakin");
        verify(friendRepo).save(any(Friend.class));
    }
}
