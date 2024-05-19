package com.example.MilkStore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.MilkStore.model.Custormer;
import com.example.MilkStore.repository.CustormerRepository;

@Service
public class CustormerService implements UserDetailsService{

    @Autowired
    private CustormerRepository custormerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Custormer> custormers = custormerRepository.findByUsername(username);
        String password = null;
        List<GrantedAuthority> list = null;

        if(custormers.isEmpty()){
            throw new UsernameNotFoundException("UserDetails have not find username = " + username);
        }

        username = custormers.get(0).getUsername();
        password = custormers.get(0).getPassword();
        list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority(custormers.get(0).getRoles()));

        return new User(username, password, list);
    }
    
    public void SaveUser(Custormer custormer){
        String newPassword = passwordEncoder.encode(custormer.getPassword());
        custormer.setPassword(newPassword);
        custormerRepository.save(custormer);
    }
}
