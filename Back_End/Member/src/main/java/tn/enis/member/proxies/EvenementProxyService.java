package tn.enis.member.proxies;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.enis.member.beans.EvenementBean;

@FeignClient(name = "EVENEMENT-SERVICE")
public interface EvenementProxyService {

    @GetMapping("/evenements/{id}")
    public EvenementBean findEvenementById(@PathVariable(name="id") Long id) ;
}
