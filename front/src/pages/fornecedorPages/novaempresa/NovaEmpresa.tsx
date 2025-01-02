
import SearchLoja from '@/components/SearchLoja';
import Menu from '@/components/Menu';
import DadosNovoEmpresa from './CriarEmpresa';
import { useParams } from 'react-router-dom';
// import {useFetch} from '@/lib/hook';


function NovaEmpresa() {
    const { username } = useParams<{ username: string }>();
    return (
        <div className="flex">
            <Menu usuarioID={username || ""}/>
            <div className="flex flex-col w-full">
                <SearchLoja />
                <div className="flex flex-col h-[92.2vh] bg-[#F5F5F5] justify-center items-center overflow-y-scroll scroll-visible">
                    <div className="flex flex-col w-full h-full justify-center items-center"> 
                        <div className="flex flex-col w-full h-full bg-[#F5F5F5] justify-center items-center">
                          <div className='flex flex-col w-[30vw] h-full'>
                            <div className='flex w-full p-5 mt-10 bg-[#EEEEEE] items-center'>
                            <span className='text-2xl'>Cadastro de empresa</span> </div>
                            <DadosNovoEmpresa/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default NovaEmpresa;
