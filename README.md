<h1 align="center">🧪 Framework de Automação Java + Playwright</h1>

<p align="center">
  <b>Este projeto é um framework robusto para automação de testes web, unindo as melhores práticas do Java, Playwright, Cucumber e Allure.</b><br/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="36"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/playwright/playwright-original.svg" width="36"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/cucumber/cucumber-plain.svg" width="36"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/junit/junit-plain.svg" width="36"/>
</p>

<hr/>

<h2>✨ Visão Geral</h2>
<p>
  Automação de cenários de teste end-to-end utilizando Java 17+, Playwright e BDD com Cucumber.<br>
  <strong>Principais recursos:</strong>
  <ul>
    <li>Testes organizados por <i>Features</i>, utilizando Gherkin</li>
    <li>Execução controlada por JUnit com suporte a relatórios Allure</li>
    <li>Reutilização de componentes e cenários por meio de Page Objects e Helper Utilities</li>
    <li>Facilidade na validação de mensagens e estados de tela</li>
  </ul>
</p>

<h2>⚙️ Como executar</h2>
<ol>
  <li>Clone o repositório:
    <pre><code>git clone &lt;SEU_REPOSITORIO&gt;</code></pre>
  </li>
  <li>Certifique-se de ter o <b>Java 17+</b> instalado.</li>
  <li>O <b>Node.js</b> é necessário para instalar e gerenciar os navegadores do Playwright via <code>npx playwright install</code>.</li>
  <li>Instale os browsers do Playwright se ainda não fez isso:
    <pre><code>npx playwright install</code></pre>
  </li>
  <li>Execute os testes usando Maven:
    <pre><code>mvn test</code></pre>
  </li>
  <li>Gere e visualize o relatório Allure:
    <pre><code>allure serve report allure-results</code></pre>
  </li>
</ol>

<h2>📁 Estrutura do Projeto</h2>
<pre>
project-root/
├── features/        # Arquivos .feature com cenários BDD
│   └── login.feature
├── steps/           # Definições dos passos (Step Definitions)
│   ├── Hook.java
│   ├── LoginSteps.java
│   └── ValidarSteps.java
├── interaction/     # Lógicas de interação, Page Objects helpers
│   ├── LoginInteraction.java
│   └── ValidarInteraction.java
├── pages/           # Page Objects com os elementos das páginas
│   └── LoginPage.java
├── runner/          # Runner da suíte de testes
│   └── RunnerTest.java
├── utils/           # Classes utilitárias e integrações
│   ├── Utils.java
│   ├── AllureFunctions.java
│   └── driver/
│       └── PlaywrightDriver.java
└── allure-results/ # Resultados de execução e relatórios   
└── pom.xml ou build.gradle  # Gerenciador de dependências
</pre>


<h2>⚠️ Instruções Importantes</h2>
<ul>
  <li>🔒 <b>Execução Paralela</b>: Por padrão, a execução paralela está habilitada para maior performance (<code>cucumber.execution.parallel.enabled=true</code>).</li>
  <li>🛠️ <b>Relatórios</b>: Os resultados são gerados automaticamente em <code>allure-results</code> e podem ser visualizados com o Allure CLI.</li>
  <li>✏️ <b>Personalização</b>: Os exemplos de cenários podem ser alterados conforme a necessidade dos seus testes.</li>
  <li>✅ <b>Mensagens de Validação</b>: Certifique-se de validar mensagens idênticas às exibidas na aplicação alvo.</li>
  <li>🏷️ <b>Execução de Tags</b>: Utilize <code>@tags</code> nos arquivos feature para execuções filtradas.</li>
  <li>🗒️ <b>Ambiente</b>: Para configurar informações de ambiente nos relatórios, edite o <code>environment.xml</code> gerado pela automação.</li>
</ul>

<h2>💡 Dicas Extras</h2>
<ul>
  <li>É possível customizar as categorias dos relatórios Allure editando o <code>categories.json</code>.</li>
  <li>Utilize <b>Step Annotations</b> do Allure para ter passos detalhados nos relatórios.</li>
  <li>O framework é extensível para outras páginas e fluxos web.</li>
</ul>

<br>
<p align="center">🚀 Framework de automação pronto para evoluir com seu time!<br>
Dúvidas ou sugestões? Abra uma <a href="https://github.com/seurepo/issues">issue</a>!</p>