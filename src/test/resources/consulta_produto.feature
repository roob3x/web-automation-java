#language: pt
Funcionalidade: Consultar produto

    @smoke
    Esquema do Cenario: Valido preco normal e preco de assinante para o produto
        Dado realizo a consulta do produto "racao"
        Quando seleciono o terceiro produto da lista
        Entao valido as informacoes do produto
            | nomeProduto   | fornecedor   | precoNormal   | precoAssianante   |
            | <nomeProduto> | <fornecedor> | <precoNormal> | <precoAssianante> |
        Quando adiciono o produto ao carrinho
        Entao valido que o detalhe do produto continua o mesmo
            | nomeProduto   | precoNormal   |
            | <nomeProduto> | <precoNormal> |

        Exemplos:
            | nomeProduto                                                                     | fornecedor  | precoNormal | precoAssianante |
            | Ração Úmida Premier Orgânico para Gatos Adultos Sabor Frango, Chia e Quinoa 70g | Premier Pet | R$ 7,99     | R$ 7,19         |
