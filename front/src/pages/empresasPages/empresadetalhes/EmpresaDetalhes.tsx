import SearchLoja from '@/components/SearchLoja';
import Menu from '@/components/Menu';
import ItensEmpresa from './ItensEmpresa';
import MenuInformacoes from './MenuInformacoes';
import { useParams } from 'react-router-dom';


function EmpresaDetalhes() {
    const { usernameID } = useParams<{ usernameID: string }>();
    return (
        <div className="flex">
            <Menu usuarioID={usernameID || "Problema ao encontrar "}/>
            <div className="flex flex-col w-full">
                <SearchLoja />
                <div className="flex h-[92.2vh] bg-[#F5F5F5] justify-center items-center">
                    <div className="flex justify-center items-center">
                        <div className="flex flex-col w-[81vw] h-[85vh] bg-slate-100 mt-[1vh] rounded-lg">
                                <ItensEmpresa/>
                            <div className="flex flex-col justify-center">
                                <MenuInformacoes />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default EmpresaDetalhes;
