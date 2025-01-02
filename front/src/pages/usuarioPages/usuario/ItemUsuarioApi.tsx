import { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom"; // Importando Link para navegação

interface UsuarioPropsApi {
    usuarioID: number;
    companyID: number;
    nome: string;
    data_entrada: Date;
    tipo: string;
    cedula: string;
    data_nascimento: Date;
    departamento: string;
    data_admissao: Date;
    salario: number;
    ativo: number;
    telefone: string;
    email: string;
    senha: string;
    rua: string;
    bairro: string;
    cidade: string;
    canton: string;
    distrito: string;
    codigo_postal: number;
    complemento: string;
}

function Usuarios() {
    const [data, setData] = useState<UsuarioPropsApi[]>([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState<string | null>(null);
    const { usernameID } = useParams();
    
    useEffect(() => {
        console.log("Iniciando requisição para a API");

        fetch("http://localhost:8080/usuario/find/all")
            .then((response) => {
                console.log("Resposta recebida:", response);
                if (!response.ok) {
                    throw new Error("Erro ao buscar dados da API");
                }
                return response.json();
            })
            .then((data: UsuarioPropsApi[]) => {
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
            <div className="flex items-center justify-center w-[100%] h-[80vh] space-x-2">
                <div className="animate-spin rounded-full h-8 w-8 border-4 border-t-blue-500 border-r-transparent border-b-blue-500 border-l-transparent"></div>
                <div className="text-blue-500">Carregando...</div>
            </div>
        );
    }

    if (error) {
        return <div className="flex items-center justify-center w-[100%] h-[80vh] space-x-2">
                <div className="text-blue-500">Erro: {error}</div>
         </div>      
               
    }
    console.log(usernameID)
    return (
        <div className="flex flex-col items-start justify-start overflow-y-auto h-[70vh] pt-[7vh]">
            {data.length > 0 ? (
                <ul className="text-black flex flex-col justify-start w-full">
                    {data.map((user) => (
                        <li key={user.usuarioID} className="flex text-sm justify-between items-center border-b-2 h-[8vh] w-full">
                            
                            <Link to={`/${usernameID}/usuarios/${user.usuarioID}`} className="flex-1 truncate text-center text-blue-500 hover:underline">
                                {user.nome}
                            </Link>

                            <span className="flex-1 truncate text-center">{user.email}</span>
                            <span className="flex-1 truncate text-center">{user.telefone}</span>
                            <span className="flex-1 truncate text-center">{user.ativo ? "Sim" : "Não"}</span>
                            <span className="flex-1 truncate text-center">{new Date(user.data_admissao).toLocaleDateString()}</span>
                        </li>
                    ))}
                </ul>
            ) : (
                <p className="text-blue-500">Nenhum cliente encontrado.</p>
            )}
        </div>
    );
}

export default Usuarios;
