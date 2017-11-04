/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.alkfejl.carrent.repository;

import hu.elte.alkfejl.carrent.model.User;
import hu.elte.alkfejl.carrent.model.Issue;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author kkereszti
 */
public interface IssueRepository extends CrudRepository<Issue, Long> {
   Iterable<Issue> findAllByUser(User user);
}
