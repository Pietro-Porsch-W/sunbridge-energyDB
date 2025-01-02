import { CalendarClock, CalendarDays, CircleDollarSign, Earth, HeartHandshake, Mail, Phone, Signpost, UsersRound } from 'lucide-react';
import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';


interface EmpresaDetalhesProps {
    companyID: string; // Identificador único do cliente
    nome: string; // Nome do cliente
    email: string; // Email do cliente
    telefone: string; // Telefone do cliente
    cidade: string; // Data de nascimento do cliente
    provincia: string; // Gênero do cliente
    data_fundacao: string; // Informação sobre dívidas
    cedula_juridica: string; // Data de registro do cliente
    setor: string; // Código postal
    numero_licenca: string; // Cidade
    rua: string; // Bairro
    bairro: string; // Rua
    canton: string; // Distrito
    distrito: string; // Província
    codigo_postal: string; // Complemento do endereço
    complemento: string; // Canton
}

function MenuInformacoes() {
    const [data, setData] = useState<EmpresaDetalhesProps | null>(null);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState<string | null>(null);
    const { companyID } = useParams<{ companyID: string }>();
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
            if (companyID) {
                try {
                    const response = await fetch(`http://localhost:8080/empresa/find/${companyID}`);
                    if (!response.ok) {
                        throw new Error("Erro ao buscar dados da API");
                    }
                    const result: EmpresaDetalhesProps = await response.json();
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
    }, [companyID]);

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
        <div className="flex flex-col justify-center mb-[23vh] mt-[13vh] items-center text-center">
            <div className='grid grid-cols-1 md:grid-cols-2 gap-6 gap-x-52 overflow-y-auto '>
                <div className='flex'>
                    <UsersRound />
                    <span className='break-words whitespace-normal ml-2'>Nome: {data.nome}</span>
                </div>
                <div className='flex'>
                <Phone />
                    <span className='break-words whitespace-normal ml-2'>Email: {data.email}</span>
                </div>
                <div className='flex'>
                <Mail />
                    <span className='break-words whitespace-normal ml-2'>Telefone: {data.telefone}</span>
                </div>
                <div className='flex'> 
                <CalendarDays />
                    <span className='break-words whitespace-normal ml-2'>Cidade: {data.cidade}</span>
                </div>
                <div className='flex'>
                <HeartHandshake />
                    <span className='break-words whitespace-normal ml-2'>Provincia: {getGenero(data.provincia)}</span>
                </div>
                <div className='flex'>
                <CircleDollarSign />
                    <span className='break-words whitespace-normal ml-2'>Data de fundação: {data.data_fundacao}</span>
                </div>
                <div className='flex'>
                <CalendarClock />   
                    <span className='break-words whitespace-normal ml-2'>Cédula de jurídica: {data.cedula_juridica}</span>
                </div>
                <div className='flex'>
                <Signpost />
                    <span className='break-words whitespace-normal ml-2'>Setor: {data.setor}</span>
                </div>
                <div className='flex'>
                <Earth />
                    <span className='break-words whitespace-normal ml-2'>Número de licença: {data.numero_licenca}</span>
                </div>
                <div className='flex'>
                <Earth />
                    <span className='break-words whitespace-normal ml-2'>Rua: {data.rua}</span>
                </div>
                <div className='flex'>
                <Earth />
                    <span className='break-words whitespace-normal ml-2'>Bairro: {data.bairro}</span>
                </div>
                <div className='flex'>
                <Earth />
                    <span className='break-words whitespace-normal ml-2'>Cantón: {data.canton}</span>
                </div>
                <div className='flex'>
                <Earth />
                    <span className='break-words whitespace-normal ml-2'>Distrito: {data.distrito}</span>
                </div>
                <div className='flex'>
                <Earth />
                    <span className='break-words whitespace-normal ml-2'>Código postal: {data.codigo_postal}</span>
                </div>
                <div className='flex'>
                <Earth />
                    <span className='break-words whitespace-normal ml-2'>Complemento: {data.complemento}</span>
                </div>
            </div>
        </div>
    );
}

export default MenuInformacoes;
