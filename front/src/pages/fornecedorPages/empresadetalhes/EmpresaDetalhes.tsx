import SearchLoja from '@/components/SearchLoja';
import Menu from '@/components/Menu';
import ItensEmpresa from './ItensEmpresa';
import MenuInformacoes from './MenuInformacoes';
import { useParams } from 'react-router-dom';

function EmpresaDetalhes() {
    const { username } = useParams<{ username: string }>();
    return (
        <div className="flex overflow-hidden">
            <Menu usuarioID={username || "Problema ao encontrar "} />
            <div className="flex flex-col w-full overflow-hidden">
                <SearchLoja />
                <div className="flex h-[92.2vh] bg-[#F5F5F5] justify-center items-center">
                    <div className="flex justify-center items-center">
                        <div className="flex flex-col w-[81vw] h-[85vh] bg-[#855b5b] mt-[1vh] overflow-hidden">
                                <ItensEmpresa/>
                            <div className="flex flex-col justify-center overflow-y-auto">
                                <MenuInformacoes/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default EmpresaDetalhes;
