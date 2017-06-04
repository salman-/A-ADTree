# Welcome to the _A-ADTree_ wiki!

## What are the shortcomings of current Attack-Defense Tree?

The ADTree is a top-down approach to show how a threat agent chooses his actions in order to obtain a specific goal. The current version of Attack-Defense Tree does not support the following concepts:

* Assets
* Threat Agent
* Vulnerabilities of the Assets

During this approach, the threat agent may try to perform an attack on different assets. The ADTree does not provide any kind of information about the assets, and their values to the companies.Also, there is a need to manage the vulnerabilities on these assets. In this way, we can evaluate the priority of vulnerability based on the cost of damage of each vulnerability. Additionally, the current ADTree does not distinguish between different threat agent who performs the attacks. But, we know that the success of attack could somehow depend on the abilities of the threat agent. 

Also, current ADTree does not measure
* Likelihood of a risk is not evaluated
* Effect of countermeasure

Every risk includes two main concepts which are uncertainty and cost of damage of the attack. The current ADTree does not evaluate the likelihood of the risk. Additionally, project managers are interested to compare the effectiveness of the different countermeasure solutions over a specific problem. Therefore, they can choose the countermeasure which mitigates the risk more, or is more cost efficient.

## What is A-ADTree project?

A-ADTree is a project based on Attack-Defense Tree, but we added the asset, vulnerability, and threat agent concepts into the current ADTree in order to fix the stated shortcomings. During this project, we did three main contributions as below:

* Alignment from ADTree to[ domain of Information System Security Risk Management](https://link.springer.com/chapter/10.1007%2F978-3-642-12544-7_16)

* Measurement of the likelihood of the risk based on threat agent, and historical data, and [OCTAVE](http://www.informit.com/articles/article.aspx?p=28469&seqNum=6)

* A tool is developed to show how the A-ADTree works
 

The below table shows the comparison between the potentiality of ADTree, and A-ADTree![A-ADTree vs ADTree](https://cloud.githubusercontent.com/assets/4312244/26752247/23a14034-4854-11e7-8480-1dfc4180025c.png)



This project has been done as a master thesis at the University of Tartu. The complete thesis can be found [here](https://comserv.cs.ut.ee/home/files/Lashkarara_softwareengineering_2017.pdf?study=ATILoputoo&reference=8762E33F0FF55E8E65DE28C8C5CA31E7F4285F2E).

