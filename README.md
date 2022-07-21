# JavaPro_Modulo9_ExercicioThreadPool
Exercício para conclusão do Módulo 9 da formação Java-PRO pela Mentorama. O objetivo do exercício é a implementação de diferentes pools de threads para execução
das funções (endpoints). Para o exercício, foram definidas duas pools de execução e as implementações destas pools estão parametrizadas na classe 
AlunoAsyncConfiguration. A execução prioritária é da pool denominada customThreadPool(). Esta é chamada sempre que o repositório do aluno 
(AlunoRepository) é acessado. Para tanto, a annotation @Async com a identificação ("customThreadPool") é assinalada em AlunoRepository. Caso a annotation @Async
for definida sem a identificação da pool a ser utilizada, a pool de thread padrão do Spring Async é executada (ForkJoinPool.commonPool()).
Observar também a importância de assinalar as annotations @EnableAsync e @ComponentScan(basePackages = {"br.com.mentorama.threadpool"}) na classe Application.
Além das indicações para pocessamento assíncrono (annotation @Async), também destaca-se o tratamento de Exception quando são executados os endpoints GET("/{id}")
e DELETE("/{id}). No caso, o tratamento da exception deve ocorrer quando é indicado um id que não existe. Ao executar estas situações via Postman, 
o processamento deve responder com um status 404 - Not Found.
A API em si é um CRUD simples de um cadastro de aluno que armazena/opera as informaçoes: id, nome e idade do aluno.  
