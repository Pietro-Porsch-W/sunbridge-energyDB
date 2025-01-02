import { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";

interface UsuarioID {
    usuarioID: number;
    companyID?: {
        companyID: number;
        nome: string;
    };
}

interface FornecedorID {
    fornecedorID: number;
    nome: string;
}

interface PedidoCompraApiResponse {
    ped_compra: number;
    data_compra: string;
    usuarioID?: UsuarioID;
    fornecedorID: FornecedorID;
    valor: number;
}

interface PedidoCompraProps {
    ped_compra: number;
    data_compra: string;
    companyName: string | null;
    fornecedorName: string | null;
    valor: number;
}

function PedidoCompra() {
    const [data, setData] = useState<PedidoCompraProps[]>([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState<string | null>(null);
    const { usernameID } = useParams();
    useEffect(() => {
        console.log("Iniciando requisição para a API de pedidos de compra...");

        fetch("http://localhost:8080/pedido_compra/find/all")
            .then((response) => {
                if (!response.ok) {
                    throw new Error("Erro ao buscar dados da API de pedidos de compra");
                }
                return response.json();
            })
            .then((responseData: PedidoCompraApiResponse[]) => {
                console.log("Dados recebidos:", responseData);

                // Processando os dados para obter apenas os campos relevantes
                const processedData: PedidoCompraProps[] = responseData.map((pedido) => {
                    const companyName = pedido.usuarioID?.companyID?.nome || "Empresa desconhecida";
                    const fornecedorName = pedido.fornecedorID?.nome || "Fornecedor desconhecido";

                    return {
                        ped_compra: pedido.ped_compra,
                        data_compra: pedido.data_compra,
                        companyName,
                        fornecedorName,
                        valor: pedido.valor,
                    };
                });

                setData(processedData);
                setLoading(false);
            })
            .catch((error) => {
                console.error("Erro ao buscar pedidos de compra:", error);
                setError(error.message);
                setLoading(false);
            });
    }, []);

    if (loading) {
        return (
            <div className="flex items-center justify-center w-full h-[80vh] space-x-2">
                <div className="animate-spin rounded-full h-8 w-8 border-4 border-t-blue-500 border-r-transparent border-b-blue-500 border-l-transparent"></div>
                <div className="text-blue-500">Carregando...</div>
            </div>
        );
    }

    if (error) {
        return (
            <div className="flex items-center justify-center w-full h-[80vh] space-x-2">
                <div className="text-red-500">Erro: {error}</div>
            </div>
        );
    }

    return (
        <div className="flex flex-col w-full overflow-y-auto pt-[6.9vh]">
            {data.length > 0 ? (
                <ul className="text-black flex flex-col justify-start w-full">
                    {data.map((pedido) => (
                        <li
                            key={pedido.ped_compra} className="flex text-sm justify-between items-center border-b-2 h-[8vh] w-full px-4">
                            <Link to={`/${usernameID}/pedidocompra/${pedido.ped_compra}`} className="flex-1 truncate text-center text-blue-500 hover:underline">
                                {pedido.ped_compra}
                            </Link>
                            <span className="flex-1 truncate text-center">{pedido.data_compra}</span>
                            <span className="flex-1 truncate text-center">{pedido.companyName}</span>
                            <span className="flex-1 truncate text-center">{pedido.fornecedorName}</span>
                            <span className="flex-1 truncate text-center">
                                {pedido.valor.toLocaleString("pt-BR", {
                                    style: "currency",
                                    currency: "BRL",
                                })}
                            </span>
                        </li>
                    ))}
                </ul>
            ) : (
                <p className="text-blue-500">Nenhum pedido de compra encontrado.</p>
            )}
        </div>
    );
}

export default PedidoCompra;
