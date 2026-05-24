package org.example.springproject.livecode.tasks.Anatolii;


import lombok.RequiredArgsConstructor;

import java.net.http.HttpHeaders;
import java.util.List;

//import static com.sun.tools.javac.comp.CompileStates.CompileState.PROCESS;

//@Service
@RequiredArgsConstructor
public class Processor {
//    private final UserRepository userRepository;
//    private final ExternalUserClient externalUserClient;
//
//    @Scheduled(cron = "${scheduler.schedule}")
//    @Transactional                                   //не нужна @transactional
//    public void process() {  //находит юсеров и меняет им статус
//        var users = userRepository.findAll();       //наверное надо искать по статусу ( findByStatus(Status.Pending) )
//        processClients(users);
//    }
//
//    @Transactional                                   //не нужна @transactional
//    public void processClients(List<User> users) {
//        for (User user : users) {
//            user.setStatus(PROCESS);
//            externalUserClient.processUser(user);
//            userRepository.save(user);
//        }
//    }
//
//    @Service
//    @RequiredArgsConstructor
//    public static class ExternalUserClient {
//        private final RestTemplate restTemplate;
////        @Transactional                               //не нужна @transactional
////        public void processClients(User request) {
////            restTemplate.exchange("/path",
////                    HttpMethod.POST,
////                    new HttpEntity<>(request, new HttpHeaders()),
////                    Void.class);
////        }
//
//        public void processUser(User user) {        //исправленный метод, изменили его название
//            HttpHeaders headers = new HttpHeaders();
//            // 1. Создаем заголовки
//            headers.setContentType(MediaType.APPLICATION_JSON);
//
//            // 2. Создаем запрос (тело + заголовки)
//            HttpEntity<User> requestEntity = new HttpEntity<>(user, headers);
//            ResponseEntity<Void> response = restTemplate.exchange(
//                    "/path",         // нужен полный URL "http://localhost:8080/api/v1/person",
//                    HttpMethod.POST,
//                    requestEntity,
//                    Void.class);
//        }
//    }
}
