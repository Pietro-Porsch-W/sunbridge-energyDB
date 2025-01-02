import { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom"; // Importando Link para navegação

interface EmpresasPropsApi {
    companyID: number;
    nome: string;
    cedula_juridica: string;
    numero_licenca: string;
    telefone: string;
    data_fundacao: string; 
}

function Empresas() {
    const [data, setData] = useState<EmpresasPropsApi[]>([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState<string | null>(null);
    const { usernameID } = useParams();
    
    useEffect(() => {
        console.log("Iniciando requisição para a API");

        fetch("http://localhost:8080/empresa/find/all")
            .then((response) => {
                console.log("Resposta recebida:", response);
                if (!response.ok) {
                    throw new Error("Erro ao buscar dados da API");
                }
                return response.json();
            })
            .then((data: EmpresasPropsApi[]) => {
                console.log("Dados recebidos:", data);
                setData(data);
                setLoading(false);
            })
            .catch((error) => {
                console.error("Erro na requisição:", error);
                setError(error.message);
                setLoading(false);
            });
    }, []);

    if (loading) {
        return (
            <div className="flex items-center justify-center pt-[35vh] space-x-2">
                <div className="animate-spin rounded-full h-8 w-8 border-4 border-t-blue-500 border-r-transparent border-b-blue-500 border-l-transparent"></div>
                <div className="text-blue-500">Carregando...</div>
            </div>
        );
    }

    if (error) {
        return <div className="pt-[30vh] space-x-2">
                    <div className="text-blue-500">Erro: {error}</div>
                </div>
    }

    return (
        <div className="flex flex-col items-start justify-start overflow-y-auto h-[70vh] pt-[7vh]">
            {data.length > 0 ? (
                <ul className="text-black flex flex-col justify-start w-full">
                    {data.map((client) => (
                        <li key={client.companyID} className="flex text-sm justify-between items-center border-b-2 h-[8vh] w-full">
                            <Link to={`/${usernameID}/empresas/${client.companyID}`} className="flex-1 truncate text-center text-blue-500 hover:underline">
                                {client.nome}
                            </Link>
                            <span className="flex-1 truncate text-center">{client.cedula_juridica}</span>
                            <span className="flex-1 truncate text-center">{client.numero_licenca}</span>
                            <span className="flex-1 truncate text-center">{client.telefone}</span>
                            <span className="flex-1 truncate text-center">{new Date(client.data_fundacao).toLocaleDateString()}</span>
                        </li>
                    ))}
                </ul>
            ) : (
                <p className="text-blue-500 pb-[20vh]">Nenhum cliente encontrado.</p>
            )}
        </div>
    );
}

export default Empresas;
