import { Button } from "@/components/ui/button";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";


interface ProjetoApiProps {
    clienteID: number;
    nome: string;
    cedula: string;
    email: string;
    telefone: string;
    ativo: boolean;
    data_nascimento: string;
    generoCliente: string;
    divida: string;
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

function ActiveClientComponent({
    cliente,
    selectedClienteID
}: {
    cliente: ProjetoApiProps | null;
    selectedClienteID: number | null;
}) {

    if (!cliente) return null;

    if (!cliente.ativo) {
        return (
            <div className="w-full h-full flex">
                <div className="flex w-[30vh] h-[10vh] border-2 border-[#830000ee] bg-[#f3242473] text-center items-center justify-center">
                    <div className="items-center">
                        <span>Ative o cliente para dar prosseguimento.</span>
                    </div>
                </div>
            </div>
        );
    }
    
    return (
        <div className="p-1">
            <Link to={`/pedidocompra/${selectedClienteID}`}>
                <Button className="">Prosseguir</Button>
            </Link>
        </div>
    );
}

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

function ProjetoApi() {
    const [data, setData] = useState<ProjetoApiProps[]>([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState<string | null>(null);
    const [selectedClienteID, setSelectedClienteID] = useState<number | null>(null);

    const handleSelectChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
        setSelectedClienteID(Number(event.target.value));
    };

    useEffect(() => {
        console.log("Iniciando requisição para a API");

        fetch("http://localhost:8000/cliente/")
            .then((response) => {
                console.log("Resposta recebida:", response);
                if (!response.ok) {
                    throw new Error("Erro ao buscar dados da API");
                }
                return response.json();
            })
            .then((data: ProjetoApiProps[]) => {
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

    const selectedCliente = data.find((cliente) => cliente.clienteID === selectedClienteID) || null;

    if (loading) {
        return (
            <div className="flex items-center justify-center pt-[35vh] space-x-2">
                <div className="animate-spin rounded-full h-8 w-8 border-4 border-t-blue-500 border-r-transparent border-b-blue-500 border-l-transparent"></div>
                <div className="text-blue-500">Carregando...</div>
            </div>
        );
    }

    if (error) {
        return <div className="text-white">Erro: {error}</div>;
    }

    return (
        <div className="flex flex-col justify-center">
            <div className="flex flex-col w-[20vh]">
                <label>
                    Selecione o cliente
                    <select name="cliente" className="p-2" onChange={handleSelectChange}>
                        <option value="">Selecione um cliente</option>
                        {data.map((cliente) => (
                            <option key={cliente.clienteID} value={cliente.clienteID}>
                                {cliente.nome}
                            </option>
                        ))}
                    </select>
                </label>
                {selectedCliente && (
                    <div className="flex flex-col mt-4 text-black w-[32vh] justify-center">
                        <div className="flex flex-col mt-4 text-black text-xl">
                            <p><strong>Nome:</strong> {selectedCliente.nome}</p>
                            <p><strong>Documento:</strong> {selectedCliente.cedula}</p>
                            <p><strong>Email:</strong> {selectedCliente.email}</p>
                            <p><strong>Telefone:</strong> {selectedCliente.telefone}</p>
                            <p><strong>Ativo:</strong> {selectedCliente.ativo ? "Sim" : "Não"}</p>
                            <p><strong>Data de Registro:</strong> {selectedCliente.data_nascimento}</p>
                            <p><strong>Gênero:</strong> {getGenero(selectedCliente.generoCliente)}</p>
                            <p><strong>Dívida:</strong> {selectedCliente.divida}</p>
                            <p><strong>Código Postal:</strong> {selectedCliente.codigo_postal}</p>
                            <p><strong>Cidade:</strong> {selectedCliente.cidade}</p>
                            <p><strong>Bairro:</strong> {selectedCliente.bairro}</p>
                            <p><strong>Rua:</strong> {selectedCliente.rua}</p>
                            <p><strong>Distrito:</strong> {selectedCliente.distrito}</p>
                            <p><strong>Província:</strong> {selectedCliente.provincia}</p>
                            <p><strong>Complemento:</strong> {selectedCliente.complemento}</p>
                            <p><strong>Canton:</strong> {selectedCliente.canton}</p>
                            <p><strong>Descrição:</strong> {selectedCliente.descricao}</p>
                        </div>
                        <div className="flex mt-10 items-center justify-center">
                            <ActiveClientComponent cliente={selectedCliente} selectedClienteID={selectedClienteID} />
                        </div>
                    </div>
                )}
            </div>
        </div>
    );
}

export default ProjetoApi;
