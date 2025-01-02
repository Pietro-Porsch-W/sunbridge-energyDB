import { BadgeCheck, CircleDollarSign, Earth, UsersRound } from 'lucide-react';
import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';


interface PedidoDetalhesProps {
    ped_compra: number;
    data_compra: string;
    data_entrega?: string;
    valor: number;
    desconto: number;
    usuarioID: {
        id: number;
        nome: string;
    };
    fornecedorID: {
        id: number;
        nome: string;
    };
    pagamento_fornecedorID: {
        id: number;
        descricao: string;
    };
}

function MenuInformacoes() {
    const [data, setData] = useState<PedidoDetalhesProps | null>(null);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState<string | null>(null);
    const { ped_compra } = useParams<{ ped_compra: string }>();
    useEffect(() => {
        const fetchData = async () => {
            if (ped_compra) {
                try {
                    const response = await fetch(`http://localhost:8080/pedido_compra/find/id/${ped_compra}`);
                    if (!response.ok) {
                        throw new Error("Erro ao buscar dados da API");
                    }
                    const result: PedidoDetalhesProps = await response.json();
                    setData(result);
                } catch (error: unknown) {
                    if (error instanceof Error) {
                        setError(error.message);
                    } else {
                        setError("Ocorreu um erro desconhecido");
                    }
                } finally {
                    setLoading(false);
                }
            } else {
                setLoading(false);
            }
        };

        fetchData();
    }, [ped_compra]);

    if (loading) {
        return (
            <div className="flex items-center justify-center pt-[35vh] space-x-2">
                <div className="animate-spin rounded-full h-8 w-8 border-4 border-t-blue-500 border-r-transparent border-b-blue-500 border-l-transparent"></div>
                <div className="text-blue-500">Carregando...</div>
            </div>
        );
    }

    if (error) {
        //  return <div className="text-white">Erro: {error}</div>;
        return <div className="flex items-center justify-center pt-[35vh] space-x-2">
            <div className="text-blue-500">Erro: {error}</div>
        </div>
    }

    if (!data) {
        return <div className="text-white">Nenhum dado encontrado.</div>;
    }

    return (
        <div className="flex flex-col justify-center mb-[23vh] items-center text-center mt-[20vh] ">
            <div className='grid grid-cols-1 md:grid-cols-2 gap-6 gap-x-52 text-2xl'>
                <div className='flex'>
                    <UsersRound />
                    <span className='break-words whitespace-normal ml-2'>Cliente: {data.usuarioID.nome}</span>
                </div>
                <div className='flex'>
                    <Earth />
                    <span className='break-words whitespace-normal ml-2'>Fornecedor: {data.fornecedorID.nome}</span>
                </div>
                <div className='flex'>
                    <BadgeCheck />
                    <span className='break-words whitespace-normal ml-2'>Pagamento descrição: {data.pagamento_fornecedorID.descricao}</span>
                </div>
                <div className='flex'>
                    <CircleDollarSign />
                    <span className='break-words whitespace-normal ml-2'>Valor: R$ {data.valor.toFixed(2)}</span>
                </div>
            </div>
        </div>
    );
}

export default MenuInformacoes;
