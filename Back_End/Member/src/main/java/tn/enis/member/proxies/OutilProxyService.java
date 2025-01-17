package tn.enis.member.proxies;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.enis.member.beans.OutilBean;

@FeignClient(name = "OUTIL-SERVICE")
public interface OutilProxyService {

    @GetMapping("/outils/{id}")
    public OutilBean findOutil(@PathVariable(name="id") Long id) ;
}
