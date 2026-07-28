package org.example.springproject.livecode.tasks.Anatolii;

//@Service
//@Slf4j
//@RequiredArgsConstructor
public class RobotUaService {   //ревью кода

    //    private final VacancyRepository vacancyRepository;
    //    private final SourceRepository sourceRepository;
    //    private final VacancyMapper vacancyMapper;
    //    private final VacancyService vacancyService;
    //
    //    private static final Logger logger = LoggerFactory.getLogger(RobotaUaService.class);
    //
    //    @Transactional
    //    public void getAllVacanciesRobotaUa() {
    //        Source source = sourceRepository.findById(1)
    //                .orElseThrow(() -> new SourceNotFoundException(String.format(SOURCE_NOT_FOUND_MESSAGE, 1)));
    //
    //        String link = source.getLink();
    //
    //        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    //        List<Callable<List<Vacancy>>> tasks = new ArrayList<>();
    //        for (int i = 1; i <= 200; i++) {
    //            tasks.add(new RobotaUaVacanciesCollector(source,
    //                    link + i,
    //                    vacancyRepository,
    //                    vacancyMapper,
    //                    vacancyService)
    //            );
    //        }
    //
    //        try {
    //            List<Future<List<Vacancy>>> futures = executorService.invokeAll(tasks);
    //
    //            for (Future<List<Vacancy>> future : futures) {
    //                try {
    //                    future.get();
    //                } catch (Exception e) {
    //                    logger.warn(e.getMessage());
    //                }
    //
    //            }
    //        } catch (InterruptedException e) {
    //            logger.warn("Thread interrupted while executing tasks: " + e.getMessage());
    //        }
    //    }
    //}
}
