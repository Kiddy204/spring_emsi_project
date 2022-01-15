package ma.kiddy204.spring_project.proposition.interfaces;

import ma.kiddy204.spring_project.proposition.dto.PropositionVo;

public interface IPropositionService {
    public PropositionVo findById(Long id);
    public void save(PropositionVo propositionVo);
    public void update(PropositionVo propositionVo);
    public void delete(PropositionVo propositionVo);
}
