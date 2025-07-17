package com.projects.splitwise.Services;

import com.projects.splitwise.Dtos.Transaction;
import com.projects.splitwise.Repositories.GroupRepository;
import com.projects.splitwise.models.Group;
import com.projects.splitwise.stratagies.HeapSettleUpStrategy;
import com.projects.splitwise.stratagies.SettleUpStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SettleUpGroupService {
   public List<Transaction> settleUpGroup(Long groupId){
       return List.of();
   }
}
