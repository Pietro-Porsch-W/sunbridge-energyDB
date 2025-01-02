import { BadgeCheck, CalendarClock, CalendarDays, CircleDollarSign, Earth, HeartHandshake, Mail, Phone, Signpost, UsersRound } from 'lucide-react';
import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';

interface ClienteDetalhesProps {
    id: string;
    nome: string;
    email: string;
    telefone: string;
    data_nascimento: string;
    generoCliente: string;
    divida: string;
    registration_date: string;
    codigo_postal: string;
    cidade: string;
    bairro: string;
    rua: string;
    distrito: string;
    provincia: string;
    complemento: string;
    canton: string;
    descricao: string;
}

function MenuInformacoes() {
    const [data, setData] = useState<ClienteDetalhesProps | null>(null);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState<string | null>(null);
    const { id } = useParams<{ id: string }>();

    const getGenero = (generoCliente: 'F' | 'M' | string): string => {
        switch (generoCliente) {
            case 'F':
                return 'Feminino';
            case 'M':
                return 'Masculino';
            default:
                return 'Não especificado';
        }
    };

    useEffect(() => {
        const fetchData = async () => {
            if (id) {
                try {
                    const response = await fetch(`http://localhost:8080/cliente/find/id/${id}`);
                    if (!response.ok) {
                        throw new Error("Erro ao buscar dados da API");
                    }
                    const result: ClienteDetalhesProps = await response.json();
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
    }, [id]);

    if (loading) {
        return (
            <div className="flex items-center justify-center pt-[35vh] space-x-2">
                <div className="animate-spin rounded-full h-8 w-8 border-4 border-t-blue-500 border-r-transparent border-b-blue-500 border-l-transparent"></div>
                <div className="text-blue-500">Carregando...</div>
            </div>
        );
    }

    if (error) {
        return (
            <div className="flex items-center justify-center pt-[35vh] space-x-2">
                <div className="text-blue-500">Erro: {error}</div>
            </div>
        );
    }

    if (!data) {
        return <div className="text-white">Nenhum dado encontrado.</div>;
    }

    return (
        <div className="flex flex-col justify-center mb-[23vh] items-center text-center mt-[20vh] ">
            <div className="grid grid-cols-1 md:grid-cols-2 gap-6 gap-x-52 text-2xl">
                <div className="flex">
                    <UsersRound />
                    <span className="break-words whitespace-normal ml-2">Nome: {data.nome}</span>
                </div>
                <div className="flex">
                    <Phone />
                    <span className="break-words whitespace-normal ml-2">Telefone: {data.telefone}</span>
                </div>
                <div className="flex">
                    <Mail />
                    <span className="break-words whitespace-normal ml-2">Email: {data.email}</span>
                </div>
                <div className="flex">
                    <CalendarDays />
                    <span className="break-words whitespace-normal ml-2">Data de Nascimento: {data.data_nascimento}</span>
                </div>
                <div className="flex">
                    <HeartHandshake />
                    <span className="break-words whitespace-normal ml-2">Gênero: {getGenero(data.generoCliente)}</span>
                </div>
                <div className="flex">
                    <CircleDollarSign />
                    <span className="break-words whitespace-normal ml-2">Dívida: {data.divida}</span>
                </div>
                <div className="flex">
                    <CalendarClock />
                    <span className="break-words whitespace-normal ml-2">Data de Registro: {data.registration_date}</span>
                </div>
                <div className="flex">
                    <Signpost />
                    <span className="break-words whitespace-normal ml-2">Código Postal: {data.codigo_postal}</span>
                </div>
                <div className="flex">
                    <Earth />
                    <span className="break-words whitespace-normal ml-2">Cidade: {data.cidade}</span>
                </div>
                <div className="flex">
                    <Earth />
                    <span className="break-words whitespace-normal ml-2">Bairro: {data.bairro}</span>
                </div>
                <div className="flex">
                    <Earth />
                    <span className="break-words whitespace-normal ml-2">Rua: {data.rua}</span>
                </div>
                <div className="flex">
                    <Earth />
                    <span className="break-words whitespace-normal ml-2">Distrito: {data.distrito}</span>
                </div>
                <div className="flex">
                    <Earth />
                    <span className="break-words whitespace-normal ml-2">Província: {data.provincia}</span>
                </div>
                <div className="flex">
                    <Earth />
                    <span className="break-words whitespace-normal ml-2">Complemento: {data.complemento}</span>
                </div>
                <div className="flex">
                    <Earth />
                    <span className="break-words whitespace-normal ml-2">Canton: {data.canton}</span>
                </div>
                <div className="flex">
                    <BadgeCheck />
                    <span className="break-words whitespace-normal ml-2">Descrição: {data.descricao}</span>
                </div>
            </div>
            {/* Botão para editar as informações */}
            <button
                className="mt-6 px-6 py-2 bg-blue-500 text-white rounded-lg hover:bg-blue-600 transition"
                onClick={() => alert('Função de edição ainda não implementada!')}
            >
                Editar Informações
            </button>
        </div>
    );
}

export default MenuInformacoes;
